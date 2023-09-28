const currencyEl_one = document.getElementById('currency-one');
const currencyEl_two = document.getElementById('currency-two');
const amountEl_one = document.getElementById('amount-one');
const amountEl_two = document.getElementById('amount-two');

const rateEl = document.getElementById('rate');
const swap = document.getElementById('swap');

function convert() {
    const currency_one = currencyEl_one.value;
    const currency_two = currencyEl_two.value;

    //fetch url (Api KEY from the exchangerate api), the path variable is set to currency_one value
    fetch(`https://v6.exchangerate-api.com/v6/c69acd627152165595155b6b/latest/${currency_one}`)
        //async task -> .then
        //will return the data as json , data which needs to be read back to the user
        .then((res) => res.json())
        .then((data) => {
            const rate = data.conversion_rates[currency_two]; //get the conversion rate

            ////calculate the amount by multiplying the first amount to the conversion rate, and use only 2 decimals points or convenience of display
            amountEl_two.value = (amountEl_one.value * rate).toFixed(2)});
}

//add event listeners which will call the convert function

//listens for the change event of the first currency
currencyEl_one.addEventListener('change', convert);

// event listener for the input amount for currency 1
amountEl_one.addEventListener('input', convert);

//listens for a change event of the second currency
currencyEl_two.addEventListener('change', convert);

// event listener for the amount for currency 2
amountEl_two.addEventListener('input', convert);

//swap listener - store currency 1 into a new variable, then store currency2 in currency 1 and store temp in currency 2
swap.addEventListener('click', () => {
    const temp = currencyEl_one.value;
    currencyEl_one.value = currencyEl_two.value;
    currencyEl_two.value = temp;
    convert();
});

//convert();