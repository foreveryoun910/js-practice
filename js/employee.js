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
let titles = ['id', 'first_name', 'last_name', 'email', 'gender', 'ip_address'];

function createTable() {
    table.setAttribute('border', '1');
    createHeader();

    let caption = document.createElement('caption');
    caption.appendChild(document.createTextNode('회원리스트'));
    table.appendChild(caption);

    for (let row of obj) {
        let tr = document.createElement('tr');
        tr.setAttribute('id', row.id);

        //console.log(row.id);

        for (let field in row) {
            let td = document.createElement('td');
            let text = document.createTextNode(row[field]);
            td.appendChild(text);
            tr.appendChild(td);
        }
        table.appendChild(tr);
    }
    document.getElementById('show').appendChild(table);

}

createTable();



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