var myIndex = 0;
var userCityChoiceId;


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
    console.log(userCityChoiceId);
    window.location.href = "city.html";
}

document.addEventListener('DOMContentLoaded', function () {
    if (window.location.pathname.includes('index.html')) {
        carousel();
        loadCitys();
    }
    if (window.location.pathname.includes('city.html')) {
        console.log("---------------")
        console.log(userCityChoiceId) // this is currently undefined. The global variable setting isn't working 
        returnUserCityChoice();
    }
})


function returnUserCityChoice() {
    return userCityChoiceId
}
