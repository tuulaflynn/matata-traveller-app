var myIndex = 0;
userCityChoiceId = null;

// function for index.html background carousel
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

// function to load the cities in the drop down menu for index.html 
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

// function to take the user from index.html to city.html
function navigateToCity() {
    // Set the global variable to the value of the selected option (which is assigned to the value property of the select tag)
    userCityChoiceId = document.getElementById("cityOption").value;
    sessionStorage.setItem("userCityChoiceId", userCityChoiceId);
    window.location.href = "city.html"
}

// function to obtain the name of the city the user choose to view from index.html
function fetchCityName() {
    return fetch(`http://localhost:8080/api/cities/` + sessionStorage.getItem("userCityChoiceId"))
        .then(response => { return response.json() })
        .then(data => {
            sessionStorage.setItem("userCityName", data.cityName);
            return data.cityName;
        });
}

/*
// function to load the cards 
function fetchAttractionCards() {
    return fetch(`http://localhost:8080/api/attractions/city/` + sessionStorage.getItem("userCityChoiceId"))
        .then(response => { return response.json() })
        .then(attractionList => {
            //console.log(attractionList);
            // console.log(attractionList[0]);
            for (let i = 0, y = 1; i < 4; i++, y++) {
                //console.log(attractionList[i].attractionName)
                document.getElementById("attractionImg" + y).src = attractionList[i].attrationImage;
                document.getElementById("attractionName" + y).innerHTML = attractionList[i].attractionName;
                document.getElementById("attractionDesc" + y).innerHTML = attractionList[i].attractionDescription;
            };
        });
}
*/

// event which calls the functions needs for each page after the DOM has loaded
document.addEventListener('DOMContentLoaded', function () {
    if (window.location.pathname.includes('index.html')) {
        carousel();
        loadCitys();
    }
    if (window.location.pathname.includes('city.html')) {
        // calling the function to get the city name by handling the promise it returns
        fetchCityName()
            .then(cityName => { document.getElementById("cityExplore").innerHTML = `Explore ` + cityName });
        //fetchAttractionCards();
    }
})