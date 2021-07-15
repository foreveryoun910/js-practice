// employee.js
// json -> obj: JSON.parse()

let json = `[{"id":1,"first_name":"Debee","last_name":"Franc","email":"dfranc0@merriam-webster.com","gender":"Non-binary","ip_address":"18.150.134.67"},
{"id":2,"first_name":"Temple","last_name":"Amar","email":"tamar1@indiatimes.com","gender":"Male","ip_address":"220.76.73.176"},
{"id":3,"first_name":"Druci","last_name":"Castillo","email":"dcastillo2@forbes.com","gender":"Female","ip_address":"52.190.199.145"},
{"id":4,"first_name":"Homerus","last_name":"Duckels","email":"hduckels3@indiatimes.com","gender":"Genderfluid","ip_address":"207.179.141.211"},
{"id":5,"first_name":"Dollie","last_name":"Van der Beek","email":"dvanderbeek4@omniture.com","gender":"Polygender","ip_address":"158.184.132.181"},
{"id":6,"first_name":"Pren","last_name":"Ding","email":"pding5@alibaba.com","gender":"Agender","ip_address":"176.34.11.221"},
{"id":7,"first_name":"Fancy","last_name":"Rigeby","email":"frigeby6@microsoft.com","gender":"Agender","ip_address":"216.43.31.18"},
{"id":8,"first_name":"Calvin","last_name":"Origan","email":"corigan7@cam.ac.uk","gender":"Non-binary","ip_address":"8.161.59.66"},
{"id":9,"first_name":"Ula","last_name":"Fridlington","email":"ufridlington8@umich.edu","gender":"Non-binary","ip_address":"15.7.174.187"},
{"id":10,"first_name":"Allison","last_name":"Antuoni","email":"aantuoni9@issuu.com","gender":"Agender","ip_address":"196.201.147.137"}]`;

//json data가 string타입 -> parsing
let obj = JSON.parse(json);

for (let row of obj) {
    console.log(row);
}


let table = document.createElement('table');
let titles = ['id', 'first_name', 'last_name', 'email', 'gender', 'ip_address', '삭제'];

function createTable() {
    table.setAttribute('border', '1');
    createHeader();

    let caption = document.createElement('caption');
    caption.appendChild(document.createTextNode('회원리스트'));
    table.appendChild(caption);
    
    for (let row of obj) {
        let tr = document.createElement('tr');
        tr.setAttribute('id', row.id);
        tr.onmouseover = changeColor; // 행에 마우스를 올리면 배경색 변함
        tr.onmouseout = originColor; // 행에서 마우스를 떼면 배경색이 원래로 돌아감
        tr.onclick = showRow; // 행을 클릭하면 내용을 보여준다

        //console.log(row.id);

        for (let field in row) {
            let td = document.createElement('td');
            let text = document.createTextNode(row[field]);
            td.appendChild(text);
            tr.appendChild(td);
        }

        // 삭제 버튼 추가
        let btn = document.createElement('button');
        btn.onclick = deleteRow;
        let text = document.createTextNode('삭제');
        btn.appendChild(text);
        let td = document.createElement('td');
        td.appendChild(btn);
        tr.appendChild(td);

        table.appendChild(tr);
    }
    document.getElementById('show').appendChild(table);

}


function createHeader() {
    let tr = document.createElement('tr');

    for (let field of titles) {
        let th = document.createElement('th');
        let text = document.createTextNode(field);
        th.appendChild(text);
        tr.appendChild(th);
    }
    table.appendChild(tr);
}


function clickFunc() {
    this.style.backgroundColor = 'yellow';
}


function changeColor() {
    this.style.backgroundColor = 'yellow';
}

function originColor() {
    this.style.backgroundColor = '';
}

function showRow() {
    let inputs = document.getElementsByTagName('input');
    //console.log(inputs);
    for (let i=0; i<inputs.length; i++) {
        inputs[i].value = this.childNodes[i].childNodes[0].nodeValue;
    }

    // let id = this.childNodes[0].childNodes[0].nodeValue;
    // let first_name = this.childNodes[1].childNodes[0].nodeValue;
    // let last_name = this.childNodes[2].childNodes[0].nodeValue;
    // let email = this.childNodes[3].childNodes[0].nodeValue;
    // let gender = this.childNodes[4].childNodes[0].nodeValue;
    // let ip_address = this.childNodes[5].childNodes[0].nodeValue;

    // document.getElementById('eid').value = id;
    // document.getElementById('first_name').value = first_name;
    // document.getElementById('last_name').value = last_name;
    // document.getElementById('email').value = email;
    // document.getElementById('gender').value = gender;
    // document.getElementById('ip_address').value = ip_address;
}


// id를 기준으로 데이터 삭제
function deleteRow(e) {
    alert('삭제합니다.'); // 팝업창
    e.stopPropagation(); // 이벤트 연쇄작용 막기

    // 화면에서 삭제, id 비교
    let id = this.parentNode.parentNode.childNodes[0].childNodes[0].nodeValue;
    //console.log(id);
    this.parentNode.parentNode.remove();

    // 실제 데이터 삭제
    for (let i=0; i<obj.length; i++) {
        if (obj[i].id == parseInt(id)) {
            obj.splice(i, 1);
            break;
        }
    }
}


function addRow() {
    let id = document.getElementById('eid').value;
    let first_name = document.getElementById('first_name').value;
    let last_name = document.getElementById('last_name').value;
    let email = document.getElementById('email').value;
    let gender = document.getElementById('gender').value;
    let ip_address = document.getElementById('ip_address').value;
    
    let ary = [id, first_name, last_name, email, gender, ip_address];

    let tr = document.createElement('tr');
    tr.onmouseover = changeColor; // 행에 마우스를 올리면 배경색 변함
    tr.onmouseout = originColor; // 행에서 마우스를 떼면 배경색이 원래로 돌아감
    tr.onclick = showRow; // 행을 클릭하면 내용을 보여준다

    for (let f of ary) {
        let td = document.createElement('td');
        let text = document.createTextNode(f);
        td.appendChild(text);
        tr.appendChild(td);
    }

    // 삭제 버튼 추가
    let btn = document.createElement('button');
    btn.onclick = deleteRow;
    let text = document.createTextNode('삭제');
    btn.appendChild(text);
    let td = document.createElement('td');
    td.appendChild(btn);
    tr.appendChild(td);

    document.getElementsByTagName('table')[0].appendChild(tr);
}


function modRow() {
    let id = document.getElementById('eid').value;

    let findTr = document.getElementById(id);
    first_name = findTr.childNodes[1].childNodes[0].nodeValue = document.getElementById('first_name').value;
    last_name = findTr.childNodes[2].childNodes[0].nodeValue = document.getElementById('last_name').value;
    email = findTr.childNodes[3].childNodes[0].nodeValue = document.getElementById('email').value;
    gender = findTr.childNodes[4].childNodes[0].nodeValue = document.getElementById('gender').value;
    ip_address = findTr.childNodes[5].childNodes[0].nodeValue = document.getElementById('ip_address').value; 
    console.log(findTr);
}


createTable();