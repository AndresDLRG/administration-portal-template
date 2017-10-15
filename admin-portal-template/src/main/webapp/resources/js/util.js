function dateAsString(millis, showTime){
	var date = new Date(millis);
	var year = 1900 + date.getYear();
	var month = 1 + date.getMonth();
	var day = date.getDate();
	var hour = date.getHours();
	var minutes = date.getMinutes();
	var seconds = date.getSeconds();
	
	var dateString = year +'-' + padWithZeroes(month, 2) + '-' + padWithZeroes(day, 2);
	if (showTime) {
		return dateString + ' ' + padWithZeroes(hour,2) + ':' + padWithZeroes(minutes,2) + ':' + padWithZeroes(seconds,2);
	}
	return dateString;
}

function padWithZeroes(number, length) {
    var myString = '' + number;
    while (myString.length < length) {
        myString = '0' + myString;
    }
    return myString;

}