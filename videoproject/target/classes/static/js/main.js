'use strict';

var singleUploadForm = document.querySelector('#singleUploadForm');
var singleFileUploadInput = document.querySelector('#singleFileUploadInput');
var singleFileUploadError = document.querySelector('#singleFileUploadError');
var singleFileUploadSuccess = document.querySelector('#singleFileUploadSuccess');


function uploadSingleFile(file) {
    var formData = new FormData();
    formData.append("file", file);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "videos/uploadFile");

    xhr.onload = function() {
        console.log(xhr.responseText);
        var response = JSON.parse(xhr.responseText);
        if(xhr.status == 200) {
            singleFileUploadError.style.display = "none";
            singleFileUploadSuccess.innerHTML = "<p>File Uploaded Successfully.</p><p>Url : <a href='" + response.videoPath + "' target='_blank'>" + response.videoPath + "</a></p>";
            singleFileUploadSuccess.style.display = "block";
        } else {
            singleFileUploadSuccess.style.display = "none";
            singleFileUploadError.innerHTML = (response && response.message) || "Some Error Occurred";
        }
    }

    xhr.send(formData);
}
// var xhr = new XMLHttpRequest();
// xhr.open("GET", "/downloadFile/SampleVideo_1280x720_1mb.mp4");



singleUploadForm.addEventListener('submit', function(event){
    var files = singleFileUploadInput.files;
    if(files.length === 0) {
        singleFileUploadError.innerHTML = "Please select a file";
        singleFileUploadError.style.display = "block";
    }
    uploadSingleFile(files[0]);
    event.preventDefault();
}, true);


function getUrl(){
    var url = ScriptApp.getService().getUrl();
    return url;
}

function doGet(requestInfo) {
    var url = ScriptApp.getService().getUrl();
    if (requestInfo.parameter && requestInfo.parameter['page'] == '2') {
        return HtmlService.createTemplateFromFile('FILE2').evaluate();
    }
    return HtmlService.createTemplateFromFile('FILE1').evaluate();
}
