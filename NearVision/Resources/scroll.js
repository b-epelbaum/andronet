var nvImagePositionsArray = [0,0,30,200,340,470,575,680,848];

function scrollbottom() {
	window.scrollTo(0,document.body.scrollHeight);
	document.getElementById('nvImage').style.visibility = 'visible';
};

function bottom()
{
	console.log("window.innerHeight="+window.innerHeight+" document.body.scrollHeight="+document.body.scrollHeight+" screen.height="+screen.height);
	setTimeout(function(){scrollbottom()},500) ;
};


function scrollToPosition(position)
{
	var scrollPositionValue = nvImagePositionsArray[position];
	console.log("#position="+position+" scroll="+scrollPositionValue);
	setTimeout(function() {window.scrollTo(0, scrollPositionValue);},1)
}

