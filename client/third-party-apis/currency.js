const currencyEl_one = document.getElementById('currency-one');
const currencyEl_two = document.getElementById('currency-two');
const amountEl_one = document.getElementById('amount-one');
const amountEl_two = document.getElementById('amount-two');

const rateEl = document.getElementById('rate');
const swap = document.getElementById('swap');

function convert() {
    const currency_one = currencyEl_one.value;
    const currency_two = currencyEl_two.value;

    //fetch url (with Api KEY from the exchangerate api), the path variable is set to currency_one value
    //which will return the data as json , data which needs to be read back to the user
    fetch(`https://v6.exchangerate-api.com/v6/c69acd627152165595155b6b/latest/${currency_one}`)
        .then((res) => res.json())
        .then((data) => {
            const rate = data.conversion_rates[currency_two]; //get the conversion rate
            
            amountEl_two.value = (amountEl_one.value * rate).toFixed(2)  //calculate the amount by multiplying the first amount to the conversion rate, and use only 2 decimals or conevnience of display
        });
}

//add event listeners which will call the convert function
currencyEl_one.addEventListener('change', convert); //listens for the change event of the first currency
amountEl_one.addEventListener('input', convert); // event listener for the amount for currency 1
currencyEl_two.addEventListener('change', convert); //listens for a change event of the second currency
amountEl_two.addEventListener('input', convert);    // event listener for the amount for currency 2
swap.addEventListener('click', () => {
    const temp = currencyEl_one.value;
    currencyEl_one.value = currencyEl_two.value;
    currencyEl_two.value = temp;
    convert();
});

convert();