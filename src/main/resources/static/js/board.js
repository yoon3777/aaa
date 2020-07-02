$(document).ready(function () {
    //작성 페이지 작성버튼 클릭
   $('#btn-write').on('click', function () {
        var data = {
            title : $('#title').val(),
            content : $('#content').val(),
            writer : $('#writer').val()
        };

        console.log(data);

       $.ajax({
           type : 'POST',
           url : '/rest/write',
           data : data
       }).done(function () {
           alert("게시글 등록 완료");
           window.location.href = "/";
       }).fail(function (error) {
           alert(JSON.stringify(error));
       });
   });

   //수정화면 수정버튼클릭
   $('#btn-update').on('click', function () {
       var data = {
           bno : $('#bno').val(),
           title : $('#title').val(),
           content : $('#content').val()
       };
       console.log(data);

       $.ajax({
           type : 'POST',
           url : '/rest/update',
           data : data
       }).done(function () {
           alert("게시글 수정 완료");
           window.location.href = "/";
       }).fail(function (error) {
           alert(JSON.stringify(error));
       });
   });

   //수정화면 삭제버튼클릭
    $('#btn-delete').on('click', function () {
        var data = {
            bno : $('#bno').val()
        };
        console.log(data);

        $.ajax({
            type : 'POST',
            url : '/rest/delete',
            data : data
        }).done(function () {
            alert("게시글 삭제 완료");
            window.location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    });

    //댓글달기
    $('#btn-reply').on('click',function () {
        var data = {
            bno : $('#bno').val(),
            rwriter : $('#rwriter').val(),
            rcontent : $('#rcontent').val()
        };
        console.log(data);

        $.ajax({
            type: 'POST',
            url: '/rest/reply/write',
            data: data
        }).done(function () {
            alert("댓글 작성 완료");
            // window.location.href = "/";
            //현재 페이지로 변환
            window.location.replace(document.location.href);
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    });

    //댓글 수정
    $('.btn-reply-update').on('click', function () {
        var data = {
            bno : $('#bno').val(),
            rno : $(this).attr("value"),
            rwriter : $('#rwriter').val(),
            rcontent : $('#rcontent').val()
        };
        console.log(data);

        $.ajax({
            type : 'POST',
            url : '/rest/reply/update',
            dataType :'text',
            data : data
        }).done(function () {
            alert("댓글 수정 완료");
            window.location.replace(document.location.href);
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    });

    //댓글 삭제
    $('.btn-reply-delete').on('click', function () {
        var data = {
            rno : $(this).attr("data-rno")
        };
        console.log(data);

        $.ajax({
            type : 'POST',
            url : '/rest/reply/delete',
            dataType :'text',
            data : data
        }).done(function () {
            alert("댓글 삭제 완료");
            window.location.replace(document.location.href);
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    });
});