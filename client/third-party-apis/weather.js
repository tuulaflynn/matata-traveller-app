// Function Definitions
function getForcast() {
    fetch(`http://api.openweathermap.org/data/2.5/forecast?q=` + sessionStorage.getItem("userCityName") + `&appid=759b73a7c2fecc7cd9334548c3729254&units=metric`)
        // the endpoint searches for temp in Celsuius due to the added units=metric parameter
        .then(response => {
            return response.json();
        })
        .then(data => {
            // Loop to populate 5 days of weather including todays weather 
            for (let i = 0, y = 1; i <= 16, y < [4]; i = i + 8, y = y + 1) {
                document.getElementById("current-temp-" + y).innerHTML = data.list[i].main.temp + "°C";

                document.getElementById("weather-desc-" + y).innerHTML = data.list[i].weather[0].description;

                document.getElementById("weather-icon-url-" + y).src = `http://openweathermap.org/img/w/` + data.list[i].weather[0].icon + `.png`;

                document.getElementById("forecast-date-" + y).innerHTML = `${new Date(data.list[i].dt_txt).toLocaleDateString()}`;
            }
        });
}
getForcast();

/*
----------- populating the data manually for todays date only ------------------------
let currentTemp1 = data.list[0].main.temp + "°C";
document.getElementById("current-temp-1").innerHTML = currentTemp1;

let weatherDesc1 = data.list[0].weather[0].description;
document.getElementById("weather-desc-1").innerHTML = weatherDesc1;

let weatherIconName1 = data.list[0].weather[0].icon;
let weatherIconUrl1 = `http://openweathermap.org/img/w/` + weatherIconName1 + `.png`
document.getElementById("weather-icon-url-1").src = weatherIconUrl1;

let isoTimestamp1 = data.list[0].dt_txt;
let date1 = new Date(isoTimestamp1);
let forecastDate1 = `${date1.toLocaleDateString()}`;
document.getElementById("forecast-date-1").innerHTML = forecastDate1;
*/