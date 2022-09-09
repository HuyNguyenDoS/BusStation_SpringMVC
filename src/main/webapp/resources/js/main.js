/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.onload = function(){
                let dates = document.querySelectorAll(".comment-date");
                for (let i = 0; i < dates.length; i++) {
                    let d = dates[i];
                    d.innerText = "Comments " + moment(d.innerText).format("MMM Do YY");
                }
            }

window.onload = function () {
    let price = document.getElementsByClassName("price");


    //dau phay trong tien
    var formatter = new Intl.NumberFormat('vi', {
        style: 'currency',
        currency: 'VND',
    });
    for (let i = 0; i < price.length; i++)
    {

        price[i].innerText = formatter.format(price[i].innerText);
    }



   
}

function addComment(idBus){
        event.preventDefault();

    fetch("/WebsiteBusXeGiaRe/api/add-comment", {
        method: 'post',
        body: JSON.stringify({
            "content": document.getElementById("commentId").value,
            "idBus": idBus
        }),
        headers:{
            "Content-Type": "application/json"
            
        }
    }).then(function(res){
        console.info(res);
        
        return res.json();
    }).then(function(data) {
        console.info(data);
        
        let area = document.getElementById("commentArea");
        area.innerHTML = `
             <div class="comment">

              <div class="comment-box">
                <div class="comment-text">${data.content}</div>
                <div class="comment-footer">
                  <div class="comment-info">

                    <span class="comment-date">${moment(data.createdDate).format("MMM Do YY")}</span>
                  </div>

                  
                </div>
              </div>
            </div>
                    ` + area.innerHTML;
            location.reload();
    });
}