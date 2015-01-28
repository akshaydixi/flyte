function onWindowLoad() {
  var message = document.querySelector('#message');
  var url = '';
  chrome.tabs.query({'active' : true, 'lastFocusedWindow' : true}, function(tabs) {
    var url = tabs[0].url;
    var xhr = new XMLHttpRequest();
    var putUrl = "http://localhost:8080";
    var params = "url=" + url;
    xhr.open("PUT", putUrl, true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function() {
      if (xhr.readyState == 4 && xhr.status == 200) {
        message.innerText = xhr.responseText;
      }
    }
    xhr.send();
  });

window.onload = onWindowLoad;
