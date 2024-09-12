// Toggle profile menu
function toggleProfileMenu() {
    document.getElementById("profileDropdown").classList.toggle("show");
}


document.getElementById('Profile').addEventListener('click', function() {
    window.location.href = "../profilepage/p.jsp"; 
});


// Close modal
function closeModal() {
    document.getElementById("profileModal").style.display = "none";
}
