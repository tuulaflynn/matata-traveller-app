var myIndex = 0;
userCityChoiceId = null;
userCityName = null;

// Function for index.html background carousel
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

// Function to load the cities in the drop down menu for index.html 
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

// Function to take the user from index.html to city.html and set sessionStorage variables for cityId and cityName
function navigateToCity() {
    // Set the global variable to the value of the selected option (which is assigned to the value property of the select tag)
    userCityChoiceId = document.getElementById("cityOption").value;
    sessionStorage.setItem("userCityChoiceId", userCityChoiceId);

    // Fetch the city name associated with the city id 'userCityChoiceId'
    fetch(`http://localhost:8080/api/cities/` + userCityChoiceId)
        .then(response => { return response.json() })
        // Set the cityName for as a sessionStorage variable (which can be accessed between pages) and as a global variable 
        .then(data => {
            userCityName = data.cityName;
            sessionStorage.setItem("userCityName", userCityName);
        })
        // Then once the sessionStorage variables have both been set, nagivate to city.html page
        .then(() => window.location.href = "city.html");
}


// Function to load the cards 
/* Note to come back to - 
   this function is called twice, when I print console.log(attractionList) it will print twice, but if this is not called in the listener event, no images show */
function fetchAttractionCards() {
    return fetch(`http://localhost:8080/api/attractions/city/` + userCityChoiceId)
        .then(response => { return response.json() })
        .then(attractionList => {
            // For each attraction, fill its corresponding src element and name and description elements
            for (let i = 0, y = 1; i < 4; i++, y++) {
                document.getElementById("attractionImg" + y).src = attractionList[i].attractionImage;
                document.getElementById("attractionName" + y).innerHTML = attractionList[i].attractionName;
                document.getElementById("attractionDesc" + y).innerHTML = attractionList[i].attractionDescription;
            };
        });
}


// Event which calls the functions needs for each page after the DOM has loaded
document.addEventListener('DOMContentLoaded', function () {
    if (window.location.pathname.includes('index.html')) {
        carousel();
        loadCitys();
    }
    if (window.location.pathname.includes('city.html')) {
        // Set the global variables to equal the city id and name (to fetch content throughout the page)
        userCityChoiceId = sessionStorage.getItem("userCityChoiceId");
        userCityName = sessionStorage.getItem("userCityName");

        // Set the header to include the city name
        document.getElementById("cityExplore").innerHTML = `Explore ` + userCityName;
        fetchAttractionCards();
    }
})