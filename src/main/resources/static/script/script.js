const bar = document.getElementById('bar');
const nav = document.getElementById('navbar');
const close = document.getElementById('close');

if (bar){
    bar.addEventListener('click', () => {
        nav.classList.add('active');
    })
}
if(close){
    close.addEventListener('click', () => {
        nav.classList.remove('active');
    })
}

// Ambil elemen-elemen yang diperlukan
const shortDescription = document.getElementById("shortDescription");
const fullDescription = document.getElementById("fullDescription");
const readMoreLink = document.getElementById("readMoreLink");

// Tambahkan peristiwa klik ke tombol "read more"
readMoreLink.addEventListener("click", function(event) {
    event.preventDefault(); // Mencegah tindakan default link

    // Toggle tampilan teks lengkap (detail produk) dan teks singkat
    fullDescription.style.display = fullDescription.style.display === "none" ? "block" : "none";
    shortDescription.style.display = shortDescription.style.display === "none" ? "block" : "none";

    // Ubah teks tombol "read more" sesuai dengan status tampilan
    if (readMoreLink.innerHTML === "Read More") {
        readMoreLink.innerHTML = "Less";
    } else {
        readMoreLink.innerHTML = "Read More";
    }
});


