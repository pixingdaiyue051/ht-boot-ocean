$(() => {
    nav(1);
});

function nav(num) {
    $.ajax({
        type: "POST",
        url: "/user/pageBind",
        data: {currentPage: num},
        success(res) {
            if (res.success) {
                $("table#info_user_table tbody").html("");
                $.each(res.data.list, (i, d) => {
                    $("table#info_user_table tbody").append("<tr><td>" + d.trueName + "</td></tr>");
                });
                $("div#nav_page_bar ul").html("");
                $.each(res.data.navigatepageNums, (i, d) => {
                    let clickDom;
                    if (d == num) {
                        clickDom = "<span style='color:gray'>" + d + "</span>";
                    } else {
                        clickDom = "<a href='javascript:void(0);' onclick='nav(" + d + ")'>" + d + "</a>";
                    }
                    $("div#nav_page_bar ul").append("<li>" + clickDom + "</li>");
                });
            }
        }
    });
}