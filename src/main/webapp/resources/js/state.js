/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function generateColor(){
    let r = parseInt(Math.random()*255);
    let g = parseInt(Math.random()*255);
    let b = parseInt(Math.random()*255);
    return `rgb(${r},${g},${b})`
}


function cateChart(id, cateLabels=[], cateInfo=[]){
    let colors =[]
    for(let i = 0; i<  cateInfo.length;i++)
        colors.push(generateColor())
    const data = {
  labels: cateLabels,
  datasets: [{
    label: 'Thống kê theo danh muc',
    data: cateInfo,
    backgroundColor: colors,
    hoverOffset: 4
  }]
};
const config = {
  type: 'doughnut',
  data: data,
};

let ctx = document.getElementById(id).getContext("2d")
new Chart(ctx, config)
}


// Biều đồ cột
function revenueChart(id,revenueLabels=[], revenueInfo=[])
{
    const data = {
  labels: revenueLabels,
  datasets: [{
    label: 'Thống kê doanh thu theo ngày',
    data: revenueInfo,
    backgroundColor: [
      'rgb(255, 99, 132)',
      'rgb(54, 162, 235)',
      'rgb(255, 205, 86)'
    ],
    hoverOffset: 4
  }]
};
const config = {
  type: 'bar',
  data: data,
};

let ctx = document.getElementById(id).getContext("2d");
new Chart(ctx, config);
}


function revenueMonthChart(id,revenueLabels=[], revenueInfo=[])
{
    const data = {
  labels: revenueLabels,
  datasets: [{
    label: 'Thống kê doanh thu theo tháng',
    data: revenueInfo,
    backgroundColor: [
      'rgb(255, 99, 132)',
      'rgb(54, 162, 235)',
      'rgb(255, 205, 86)'
    ],
    hoverOffset: 4
  }]
};
const config = {
  type: 'line',
  data: data,
};

let ctx = document.getElementById(id).getContext("2d")
new Chart(ctx, config);
}

// CHART STATISTIC
//function generateColor() {
//    let r = parseInt(Math.random() * 255);
//    let g = parseInt(Math.random() * 255);
//    let b = parseInt(Math.random() * 255);
//
//    return `rgb(${r},${g},${b})`;
//}

function cvChart(cvLabels = [], cvInfo = []) {
    let colors = [];

    for (let i = 0; i < cvInfo.length; i++)
        colors.push(generateColor());

    const data = {
        labels: cvLabels,
        datasets: [{
                label: 'Thống kê doanh thu theo quý',
                data: cvInfo,
                backgroundColor: [
      'rgb(255, 99, 132)',
      'rgb(54, 162, 235)',
      'rgb(255, 205, 86)'
    ],
                hoverOffset: 4
            }]
    };

    const config = {
        type: 'doughnut',
        data: data
    };

    let ctx = document.getElementById("doughnutchart").getContext("2d");
    new Chart(ctx, config);

//let ctx = document.getElementById(id).getContext("2d")
//new Chart(ctx, config);
}

//Gửi điều kiện
function sendCondition(){
    let sM = document.getElementsByName("rbdM");
    let sY = document.getElementsByName("rdbY");

    var year;
    var period;

    for (var i = 0; i < sY.length; i++) {
        if (sY[i].checked == true)
            year = sY[i].value;
   }

    for (var i = 0; i < sM.length; i++) {
        if (sM[i].checked == true)
            period = sM[i].value;
    }
    
    revenuePeriodChart(period, year);
}

function revenuePeriodChart(period, year){
    event.preventDefault();

    fetch("/WebsiteBusXeGiaRe/api/state", {
        method: 'post',
        body: JSON.stringify({
            
            "period": period,
            "year": year
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {

        return res.json();
    }).then(function (data) {
        
        let area = document.getElementById("chartTable");
        let section = document.getElementById("doughnutchart");
        let cvLabels = [], cvInfo = [];

 
        data.forEach(i => {
            area.innerHTML += `
            
                <tr>
                    <td>${i[5]}</td>
                    <td>${i[0]}/${i[1]} </td>
                    <td>${i[13]} VND</td>
                </tr>
                            `;
            cvLabels.push(i[9] + " - " + i[10]);
            cvInfo.push(i[5]);
        });
        
        cvChart(cvLabels, cvInfo);
        
    }); 
}
