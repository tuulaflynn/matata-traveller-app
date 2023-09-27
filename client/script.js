var myIndex = 0;
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
function getQueryParam(param) {
        const urlParams = new URLSearchParams(window.location.search);
        return urlParams.get(param);
    }

    document.addEventListener('DOMContentLoaded', function() {
        // Get the value of the "city" query parameter
        const city = getQueryParam('city');

        // Use the value to determine which city's information to display
        if (city) {
            // Display content for the selected city
            document.getElementById('cityName').textContent = city;
            // Add more logic to display city-specific content here
        } else {
            // Handle the case where no city is selected
        }
});