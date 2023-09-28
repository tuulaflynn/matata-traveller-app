var myIndex = 0;
userCityChoiceId = null;


function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";
    }
    myIndex++;
    if (myIndex > x.length) {
        myIndex = 1;
    }
    x[myIndex - 1].style.display = "block";
    setTimeout(carousel, 3500); // Change image every 3.5 seconds
}

function loadCitys() {
    let content = `<option value="" disabled selected>Select</option> `
    fetch('http://localhost:8080/api/cities').then(response => response.json())
        .then(data => {
            for (let eachData of data) {
                content += `<option value=${eachData.cityId}>${eachData.cityName}</option>`;
            }
            document.getElementById("cityOption").innerHTML = content;
        });
}

function navigateToCity() {
    // Set the global variable to the value of the selected option (which is assigned to the value property of the select tag)
    userCityChoiceId = document.getElementById("cityOption").value;
    sessionStorage.setItem("userCityChoiceId", userCityChoiceId);
    window.location.href = "city.html"
}


function fetchCityName() {
    return fetch(`http://localhost:8080/api/cities/` + sessionStorage.getItem("userCityChoiceId"))
        .then(response => { return response.json() })
        .then(data => {
            sessionStorage.setItem("userCityName", data.cityName);
            return data.cityName;
        });
}

document.addEventListener('DOMContentLoaded', function () {
    if (window.location.pathname.includes('index.html')) {
        carousel();
        loadCitys();
    }
    if (window.location.pathname.includes('city.html')) {
        // calling the function to get the city name by handling the promise it returns
        fetchCityName()
            .then(cityName => { document.getElementById("cityExplore").innerHTML = `Explore ` + cityName });
    }
})

function returnUserCityChoice() {
    return sessionStorage.getItem("userCityChoiceId");
}
