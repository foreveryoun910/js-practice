// car.js

function createCal() {
    let userYear = document.getElementById("year").value;
    let userMonth = document.getElementById("month").value;

    let now = new Date(userYear, userMonth - 1, 1);
    let firstDay = now.getDay(); // 요일정보: 0 ~ 6
    console.log(firstDay);


    let today = new Date(userYear, userMonth, 0); // 2021, 7, 0 => 6월 마지막 날
    let year = today.getFullYear();
    let month = today.getMonth() + 1; // 1월: 0, 7월: 6
    let date = today.getDate();

    console.log(`년: ${year}, 월: ${month}, 일: ${date}`);


    let days = ["Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat"];
    let all = "<table border='1'><tr>";

    for (let i=0; i<days.length; i++) {
        if (i % 7 == 0) { // 일요일은 빨간색
            all += "<td style='background-color: red; color: white;'>" + days[i] + "</td>";
        } else if (i % 6 == 0) { // 토요일은 파란색
            all += "<td style='background-color: blue color: white;'>" + days[i] + "</td><tr></tr>";
        } else { // 평일
            all += "<td>" + days[i] + "</td>"
        }
    }
    all += "</tr>"

    //요일의 위치 맞춰주기
    for (let i=0; i<firstDay; i++) {
        all += "<td></td>";
    }

    for (let i=1; i<date; i++) {
        if ((firstDay + i) % 7 == 0) {
            all += "<td style='background-color: red; color: white;'>" + i + "</td>";
        } else if ((firstDay + i) % 7 == 1) {
            all += "<td style='background-color: blue; color: white;'>" + i + "</td><tr></tr>";
        } else {
            all += "<td>" + i + "</td>";
        }
    }
    all += "</tr></table>"
    document.write(all);
}