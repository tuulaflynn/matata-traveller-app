var myIndex = 0;
let userCityChoiceId = null;
carousel();

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


document.addEventListener('DOMContentLoaded', function loadCitys() {
    let content = `<option value="" disabled selected>Select</option> `
    fetch('http://localhost:8080/api/cities').then(response => response.json())
        .then(data => {
            console.log(data);
            for (let eachData of data) {
                console.log(eachData.cityName)
                content += `<option value=${eachData.cityName}>${eachData.cityName}</option>`;
            }
            console.log(content);
            document.getElementById("cityOption").innerHTML = content;
        });
})


function storeUserCityChoice(userCityChoice) {
    userCityChoiceId = userCityChoice;
}

function returnUserCityChoice() {
    return userCityChoiceId
}
