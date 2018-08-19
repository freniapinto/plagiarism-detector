(function () {
    if (window.addEventListener) {
        window.addEventListener('load', runhigh, false);
        window.addEventListener('load', runmed, false);
        window.addEventListener('load', runlow, false);
    } else if (window.attachEvent) {
        window.attachEvent('onload', run);
    }

    function runhigh() {
		var t = document.getElementById('reportListhigh');
        var rows = t.rows; //rows collection - https://developer.mozilla.org/en-US/docs/Web/API/HTMLTableElement
		for (var i=0; i<rows.length; i++) {
			rows[i].onclick = function (event) {
				//event = event || window.event; // for IE8 backward compatibility
				//console.log(event, this, this.outerHTML);
				if (this.parentNode.nodeName == 'THEAD') {
					return;
				}
				var cells = this.cells; //cells collection
				var f1 = document.getElementById('file1');
				var f2 = document.getElementById('file2');
				f1.value = cells[0].innerHTML;
				f2.value = cells[1].innerHTML;
			};
		}
    }
    
    function runmed() {
		var t = document.getElementById('reportListmed');
        var rows = t.rows; //rows collection - https://developer.mozilla.org/en-US/docs/Web/API/HTMLTableElement
		for (var i=0; i<rows.length; i++) {
			rows[i].onclick = function (event) {
				//event = event || window.event; // for IE8 backward compatibility
				//console.log(event, this, this.outerHTML);
				if (this.parentNode.nodeName == 'THEAD') {
					return;
				}
				var cells = this.cells; //cells collection
				var f1 = document.getElementById('file1');
				var f2 = document.getElementById('file2');
				f1.value = cells[0].innerHTML;
				f2.value = cells[1].innerHTML;
			};
		}
    }
    
    function runlow() {
		var t = document.getElementById('reportListlow');
        var rows = t.rows; //rows collection - https://developer.mozilla.org/en-US/docs/Web/API/HTMLTableElement
		for (var i=0; i<rows.length; i++) {
			rows[i].onclick = function (event) {
				//event = event || window.event; // for IE8 backward compatibility
				//console.log(event, this, this.outerHTML);
				if (this.parentNode.nodeName == 'THEAD') {
					return;
				}
				var cells = this.cells; //cells collection
				var f1 = document.getElementById('file1');
				var f2 = document.getElementById('file2');
				f1.value = cells[0].innerHTML;
				f2.value = cells[1].innerHTML;
			};
		}
    }

})();

