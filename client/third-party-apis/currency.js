const currencyOne = document.getElementById('currency-one');
const currencyTwo = document.getElementById('currency-two');
const amountOne = document.getElementById('amount-one');
const amountTwo = document.getElementById('amount-two');

const rateEl = document.getElementById('rate');
const swap = document.getElementById('swap');

function convert() {
    const currencyOneForConversion = currencyOne.value;
    const currencyTwoForConversion = currencyTwo.value;

    //fetch url (Api KEY from the exchangerate api), the path variable is set to currency_one value
    fetch(`https://v6.exchangerate-api.com/v6/c69acd627152165595155b6b/latest/${currencyOneForConversion}`)
        //async task -> .then
        //will return the data as json , data which needs to be read back to the user
        .then((res) => res.json())
        .then((data) => {
            const rate = data.conversion_rates[currencyTwoForConversion]; //get the conversion rate

            ////calculate the amount by multiplying the first amount to the conversion rate, and use only 2 decimals points or convenience of display
            amountTwo.value = (amountOne.value * rate).toFixed(2)});
}

//add event listeners which will call the convert function

//listens for the change event of the first currency
currencyOne.addEventListener('change', convert);

// event listener for the input amount for currency 1
amountOne.addEventListener('input', convert);

//listens for a change event of the second currency
currencyTwo.addEventListener('change', convert);

// event listener for the amount for currency 2
amountTwo.addEventListener('input', convert);

//swap listener - store currency 1 into a new variable, then store currency2 in currency 1 and store temp in currency 2
swap.addEventListener('click', () => {
    const temp = currencyOne.value;
    currencyOne.value = currencyTwo.value;
    currencyTwo.value = temp;
    convert();
});
