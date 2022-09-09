/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function  addToCart(scheduleId,departure, destination, busName, categoryBus, ticketPrice, seatNumber, departureDate, departureTime) {
    event.preventDefault();
    fetch("/WebsiteBusXeGiaRe/api/cart", {
        method: 'post',
        body: JSON.stringify({
            "scheduleId": scheduleId,
            "departure": departure,
            "destination":destination,
            "busName":busName,
            "categoryBus":categoryBus,
            "price": ticketPrice,
            "quantity": 1,
            "seatNumber": seatNumber,
            "departureDate": departureDate,
            "departureTime": departureTime
            
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json()
    }).then(function (data) {
        let d = document.getElementById("quantityTicket");
        d.innerText = data;
    })
}

function removeItemFromCart(scheduleId) {
    event.preventDefault();
    if (confirm("Bạn có chắc chắn hủy vé không?") == true) {
        fetch(`/WebsiteBusXeGiaRe/api/cart/${scheduleId}`, {
            method: "delete",
            
//        }).then(res => {
//            if (res.status == 200) {//thanh cong
//                let row = document.getElementById(`ticket${scheduleId}`);
//                row.style.display = "none";
//            } else
//                alert("Đã có lỗi xảy ra!!!");
        }).then(function (res) {
            return res.json()
        
        }).then(function (data) {
            let counter = document.getElementById("quantityTicket");
            counter.innerText = data.quantity;
            let quantity = document.getElementById("quantity");
            quantity.innerText = data.quantity;
            let amount = document.getElementById("amountCart");
            amount.innerText = data.total;
            let row = document.getElementById(`ticket${scheduleId}`);
            row.style.display = "none";
            
        })
    }
}

function updateCart(obj, scheduleId, seatNumber)
{
   event.preventDefault();
   if(obj.value <= seatNumber) {
       fetch("/WebsiteBusXeGiaRe/api/cart", {
           method: "put",
           body: JSON.stringify({
               "scheduleId": scheduleId,
                "departure": "",
                "destination": "",
                "busName":"",
                "categoryBus":"",
                "price": 0,
                "quantity": obj.value,
                "seatNumber": 0,
                "departureDate": "",
                "departureTime": ""
                
           }),
           headers: {
               "Content-Type": "application/json"
           }
       }).then(function (res) {
           return res.json()
       }).then(function (data){
            let counter = document.getElementById("quantityTicket");
            counter.innerText = data.quantity;
            let quantity = document.getElementById("quantity");
            quantity.innerText = data.quantity;
            let amount = document.getElementById("amountCart");
            amount.innerText = data.total;
       })
   }
    
}

function payment(id) {
    event.preventDefault();
    //if (quantity != 0) {
        if (confirm("Tiến hành thanh toán?") == true) {
            fetch(`/WebsiteBusXeGiaRe/api/payment/${id}`, {
                method: "post",
                headers: {
                    "Content-Type": "application/json"
                }
            }).then(function (res) {
                return res.json()
            }).then(function (code) {
                console.info(code);
                location.reload(); // Reload lại trang
            })
            alert("Bạn đã đặt vé thành công");
        }
    //}
    else
        alert("Bạn chưa đặt vé nào!!!");

}

function pay() {
    event.preventDefault();
    //if (quantity != 0) {
        if (confirm("Tiến hành thanh toán?") == true) {
            fetch("/WebsiteBusXeGiaRe/api/payment", {
                method: "post",
                headers: {
                    "Content-Type": "application/json"
                }
            }).then(function (res) {
                return res.json()
            }).then(function (code) {
                console.info(code);
                location.reload(); // Reload lại trang
            })
            alert("Bạn đã đặt vé thành công");
        }
    //}
    else
        alert("Bạn chưa đặt vé nào!!!");

}





