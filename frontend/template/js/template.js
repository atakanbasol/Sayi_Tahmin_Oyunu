

//#########################################################
//NAVBAR
//darkLight
let darkLight = () => {
    document.body.classList.toggle("dark_mode");
}

//TAGS
$(document).ready(function () {
    const apiData = ["adana", "bursa", "ceyhan", "malatya", "istanbul", "izmir", "diyarbakır", "elazığ"];
    $("#tags").autocomplete({
        source: apiData
    });
});


//#########################################################
// FOOTER 

//Date
document.getElementById("next_year").innerHTML = new Date().getFullYear();
// $("#next_year").html(new Date().getFullYear());

// back to top
$(window).scroll(function () {
    if ($(this).scrollTop() > 100) {
        $("#back_top").fadeIn("slow");
    } else {
        $("#back_top").fadeOut("slow");
    }
});