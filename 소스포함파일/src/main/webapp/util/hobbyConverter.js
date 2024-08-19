/**
 * hobby value converter 
 */

function hobbyConverter(hobbySelect, allHobby) {
    var conversionHobby = ["0", "0", "0", "0", "0"];

    // 서버로 전송할 데이터로 변환
    hobbySelect.forEach(function(hobby) {
        for(let i in allHobby) {
            if(allHobby[i] == hobby)
                conversionHobby[i] = "1";
        }
    });
    conversionHobby.join("");
    console.log("js파일 : "+conversionHobby);
    return conversionHobby;
}