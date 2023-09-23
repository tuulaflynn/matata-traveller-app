// Global Variables and Constants
// let user_city_name = "london";

// Function Definitions
function getForcast(user_city_name) {
    fetch(`http://api.openweathermap.org/data/2.5/forecast?q=` + user_city_name + `&appid=759b73a7c2fecc7cd9334548c3729254&units=metric`)
        // the endpoint searches for temp in Celsuius due to the added units=metric parameter
        .then(response => {
            console.log(response);
            console.log("---------------------");
            return response.json();
        })
        .then(data => {
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


            let currentTemp2 = data.list[8].main.temp + "°C";
            document.getElementById("current-temp-2").innerHTML = currentTemp2;

            let weatherDesc2 = data.list[8].weather[0].description;
            document.getElementById("weather-desc-2").innerHTML = weatherDesc2;

            let weatherIconName2 = data.list[8].weather[0].icon;
            let weatherIconUrl2 = `http://openweathermap.org/img/w/` + weatherIconName2 + `.png`
            document.getElementById("weather-icon-url-2").src = weatherIconUrl2;

            let isoTimestamp2 = data.list[8].dt_txt;
            let date2 = new Date(isoTimestamp2);
            let forecastDate2 = `${date2.toLocaleDateString()}`;
            document.getElementById("forecast-date-2").innerHTML = forecastDate2;


            let currentTemp3 = data.list[16].main.temp + "°C";
            document.getElementById("current-temp-3").innerHTML = currentTemp3;

            let weatherDesc3 = data.list[16].weather[0].description;
            document.getElementById("weather-desc-3").innerHTML = weatherDesc3;

            let weatherIconName3 = data.list[16].weather[0].icon;
            let weatherIconUrl3 = `http://openweathermap.org/img/w/` + weatherIconName3 + `.png`
            document.getElementById("weather-icon-url-3").src = weatherIconUrl3;

            let isoTimestamp3 = data.list[16].dt_txt;
            let date3 = new Date(isoTimestamp3);
            let forecastDate3 = `${date3.toLocaleDateString()}`;
            document.getElementById("forecast-date-3").innerHTML = forecastDate3;
        });
}
getForcast("Cardiff");

/*
// Event Listeners or Initialisers 
document.addEventListener('DOMContentLoaded', () => {
    // Set up event listeners or perform initial actions here which will happen only after the document is loaded
    document.getElementById('getWeatherBtn').addEventListener('click', getWeather());

});
*/