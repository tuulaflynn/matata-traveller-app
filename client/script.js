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
        //traverse the array
            for (let eachData of data) {
            //+= -- append the content
                content += `<option value=${eachData.cityId} > ${eachData.cityName}</option>`;
            }
            //use JS to manipulate the DOM
            //the innerHTML of the element with id "cityOption" should be content
            document.getElementById("cityOption").innerHTML = content; //get me the element with id cityOption , and that element innerHTML property has to be content
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

             //for the currency
             userCityCurrency = data.cityCurrency;
             sessionStorage.setItem("userCityCurrency", userCityCurrency);
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

// Function to load the categories from the database into a checkbox form
function loadCategories() {
    fetch('http://localhost:8080/api/categories').then(response => response.json())
        .then(data => {
            let content = ``;
            for (let i = 0; i < data.length; i++) {
                let categoryId = data[i].categoryId;
                let categoryName = data[i].categoryName;
                content += `<div class="form-check">
                <input class="form-check-input" type="checkbox" value="`+ categoryId + `" id="category` + i + `">
                    <label class="form-check-label" for="category` + i + `">`
                    + categoryName +
                    `</label>
            </div>`
            }

            // Loop to set innerHtml to content as there are multiple places to load the categories 
            var elements = document.getElementsByClassName("loadCategories");
            for (var i = 0; i < elements.length; i++) {
                elements[i].innerHTML = content;
            }
        });
}


// Function to load the threads from the database for a city with id 'userCityChoiceId'
function loadThreads() {
    fetch('http://localhost:8080/api/threads/city/' + userCityChoiceId)
        .then(response => response.json())
        .then(data => {
            let content = ``;
            for (let i = 0; i < data.length; i++) {
                let thread = data[i];
                let threadCategories = ``;

                // Loop to obtains all the category names for a single thread
                thread.allCategories.forEach(category => {
                    threadCategories += category.categoryName + `    `;
                });

                // Display each thread in a card with its category as a label
                content += `<div class="card mb-3">
                <div class="card-body">
                    <h5 class="card-title">`+ thread.threadDate + `</h5>
                    <p class="card-text"> ` + thread.threadContent + `</p>
                    <div class="form-check">
                        <input id="thread"` + thread.threadId + `class="form-check-input" type="checkbox" value="thread"` + thread.threadId + `" id="category` + i + `">
                        <label class="form-check-label" for="thread` + thread.threadId + `">`
                    + threadCategories +
                    `</label>
                    </div>
                </div>
            </div>`
            }
            // Set the element in city.html
            document.getElementById("allThreads").innerHTML = content;
        });
}

/* 
Functional to add a thread, not currently working so commented out for now
function addThread() {
    // Code taken from the internet to get the current date
    let today = new Date();
    let year = today.getFullYear();
    let month = String(today.getMonth() + 1).padStart(2, '0'); // Months are 0-indexed, so we add 1
    let day = String(today.getDate()).padStart(2, '0');
    let formattedDate = year + '-' + month + '-' + day;

    let cityDtoFromCurrentCity = null;
    let categoriesDtoList = [];
    let checkboxes = document.querySelectorAll('input[type="checkbox"]:checked');


    fetch("http://localhost:8080/api/cities/" + userCityChoiceId)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            cityDtoFromCurrentCity = data
        })
        .then(() => {
            var selectedValues = Array.from(checkboxes).map(function (checkbox) {
                fetch("http://localhost:8080/api/categories/" + checkbox.value)
                    .then(response => response.json())
                    .then(data => {
                        console.log(data);
                        categoriesDtoList.push(data)
                    });
            })
        });

    console.log("cityDtoFromCurrentCity:  " + cityDtoFromCurrentCity);
    console.log("categoriesDtoList:  " + categoriesDtoList);

    // Construct the javascript object for the request body as the object goes through to the backend it will get copied into a java object.
    let newThread = {
        threadId: 0,
        threadContent: document.getElementById("addThreadTitle").value,
        threadDate: formattedDate,
        cityDto: cityDtoFromCurrentCity,
        allCategoriesDto: categoriesDtoList,
    }

    // Use fetch api with post method to add the book
    fetch('http://localhost:8080/api/threads', {
        method: 'POST',
        body: JSON.stringify(newThread),   // JSON.stringify() will convert javascript object to JSON, which is the needed format for requests and responses
        headers: { "Content-type": "application/json; charset=UTF-8" }
    })
        .then((response) => { response.json })
        .then((data) => console.log(data));
}
*/


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

        //set the city's currency
        userCityCurrency=sessionStorage.getItem("userCityCurrency");

        // Set the header to include the city name
        document.getElementById("cityExplore").innerHTML = `Explore ` + userCityName;
        fetchAttractionCards();
        loadCategories();
        loadThreads();
    }
})