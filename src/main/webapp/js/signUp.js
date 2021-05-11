document.querySelector("#join-form").addEventListener("submit", e => {
    e.preventDefault();
    if (!isPwEqual()) {
        // todo : Don't use alert()
        alert("비밀번호가 다릅니다.");
        return;
    }
    e.target.submit();
});

function isPwEqual() {
    const pw1 = document.querySelector("#password");
    const pw2 = document.querySelector("#password-check");
    return pw1.value === pw2.value;
}