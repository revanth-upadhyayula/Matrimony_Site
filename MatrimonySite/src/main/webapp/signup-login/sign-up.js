document.addEventListener("DOMContentLoaded", () => {
    // Select both 'Get started' buttons
    const getStartedButtons = document.querySelectorAll("button");

    // Loop through the buttons and add click event listeners
    getStartedButtons.forEach(button => {
        button.addEventListener("click", () => {
            window.location.href = "../profile/profile.jsp";
        });
    });
});