const time = {
  start: new Date(2020, 2, 17, 13, 30, 0), //월이 0부터 시작함
  end: new Date(2020, 2, 17, 15, 50, 0), // 월이 0부터 시작함
  color: "#123456"
};

const studytime = new Array(25); //0번째 방은 안씀

// 배열 초기화
function init() {
  for (var i = 1; i <= 24; i++) {
    studytime[i] = new Array();
  }
}

function difftime(time) {
  //   console.log(time.start.getFullYear());
  //   console.log(time.start.getMonth());
  //   console.log(time.start.getDate());
  //   console.log(time.start.getHours());
  //   console.log(time.start.getMinutes());
  //   console.log(time.start.getSeconds());

  // 이후시간보다 이전시간이 클경우 예외처리
  if (time.end - time.start < 0) {
    const tmp = time.start;
    time.start = time.end;
    time.end = tmp;
  }

  const timeGap = new Date(0, 0, 0, 0, 0, 0, time.end - time.start);
  const diffHour = timeGap.getHours(); // 시간
  const diffMin = timeGap.getMinutes(); // 분
  const diffSec = timeGap.getSeconds(); // 초

  //   console.log(diffHour);
  //   console.log(diffMin);
  //   console.log(diffSec);

  // 시간이 넘어가지 않을경우
  if (diffHour == 0 && time.start.getMinutes() + diffMin <= 60) {
    studytime[time.start.getHours()] = new Array({
      start: time.start.getMinutes(),
      end: time.start.getMinutes() + diffMin,
      color: "#123456"
    });
  }

  // 시간이 넘어갈경우
  else {
    // 다음날까지 선택한 경우
    if (
      time.start.getDate() !== time.end.getDate() ||
      time.start.getMonth() !== time.end.getMonth() ||
      time.start.getFullYear() !== time.end.getFullYear()
    ) {
      // 시작값은 초기 분값 ~ 60까지
      studytime[time.start.getHours()] = new Array({
        start: time.start.getMinutes(),
        end: 60,
        color: "#123456"
      });

      for (var i = time.start.getHours() + 1; i <= 24; i++) {
        studytime[i] = new Array({
          start: 0,
          end: 60,
          color: "#123456"
        });
      }
    }

    // 다음날까지 선택하지 않은 경우
    else {
      // 시작값은 초기 분값 ~ 60까지
      studytime[time.start.getHours()] = new Array({
        start: time.start.getMinutes(),
        end: 60,
        color: "#123456"
      });

      // 그 사이 시간은 전부 풀로
      for (var i = 1; i <= diffHour; i++) {
        studytime[time.start.getHours() + i] = new Array({
          start: 0,
          end: 60,
          color: "#123456"
        });
      }

      // 끝값은 0 ~ 초기 분값
      studytime[time.end.getHours()] = new Array({
        start: 0,
        end: time.end.getMinutes(),
        color: "#123456"
      });
    }
  }

  console.log(studytime);
}

init();
difftime(time);
