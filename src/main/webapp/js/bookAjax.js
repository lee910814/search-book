$(document).ready(() => {
    $(".rental-button").click((e) => {
        $.ajax({
            url: "rental.jsp",
            type: "post",
            data: {
                id: e.target.value
            }
        }).complete({message: "대여되었습니다."}, reply)

    })

    $(".return-button").click((e) => {
        $.ajax({
            url: "return.jsp",
            type: "post",
            data: {
                id: e.target.value
            }
        }).complete({message: "반납되었습니다."}, reply)
    })

    $(".register-button").click((e) => {
        $.ajax({
            url: "register.jsp",
            type: "post",
            data: {
                id: e.target.value
            }
        }).complete({message: "등록되었습니다."}, reply)
    })
})

/**
 * Ajax complete callback function
 * @param resp ajax response
 * @param message message to be sent to user
 */
function reply(resp, message) {
    const status = resp.status;
    if (status !== 200) {
        const msg = getErrMsg(status);
        alert(msg);
        return;
    }

    alert(message);
}

/**
 * Return error message
 * @param statusCode HTTP response status code
 * @returns {string} Error message
 */
function getErrMsg(statusCode) {
    switch (statusCode) {
        case 400:
            return "잘못된 요청입니다.";
        case 401:
            return "로그인이 필요합니다.";
        case 405:
            return "method not allowed";
        default:
            return `Unhandled Code: ${statusCode}`;
    }
}