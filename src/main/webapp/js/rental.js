$(document).ready(() => {
    $(".rental-button").click((e) => {
        $.ajax({
            url: "rental.jsp",
            type: "post",
            data: {
                id: e.target.value
            }
        // todo : Do not use alert
        }).done(() => {
            alert("대여되었습니다.")
        }).fail(() => {
            alert("오류 발생")
        })
    })
})