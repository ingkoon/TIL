  ///////////////////////// select box 설정 (지역, 매매기간) /////////////////////////
      let date = new Date();
      const root = location.origin+"/whereismyhome/";
      window.onload = function () {

        // 브라우저가 열리면 시도정보 얻기.
        console.log(root);
        sendRequest("sido", "command=sidoNames");
        //sendRequest("sido",);
      };


      // https://juso.dev/docs/reg-code-api/
      // let url = "https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes";
      // let regcode = "*00000000";
      // 전국 특별/광역시, 도
      // https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes?regcode_pattern=*00000000

      // 시도가 바뀌면 구군정보 얻기.
      document.querySelector("#sido").addEventListener("change", function () {
        if (this[this.selectedIndex].value) {
          let regcode = this[this.selectedIndex].value.substr(0, 2) + "*00000";
          sendRequest("gugun", `command=gugunNames&sidoName=${this[this.selectedIndex].value}`);
        } else {
          initOption("gugun");
          initOption("dong");
        }
      });

      // 구군이 바뀌면 동정보 얻기.
      document.querySelector("#gugun").addEventListener("change", function () {
        if (this[this.selectedIndex].value) {
//          let regcode = this[this.selectedIndex].value.substr(0, 5) + "*";
        	const sidoDiv = document.querySelector("#sido");
        	const sidoName = sidoDiv[sidoDiv.selectedIndex].value;
        	const gugunName = this[this.selectedIndex].value;
        	console.log(sidoName,gugunName);
          sendRequest("dong", `command=dongNames&sidoName=${sidoName}&gugunName=${gugunName}`);
        } else {
          initOption("dong");
        }
      });

      function sendRequest(selid, param) {
    	  console.log(location);
    	  const url = root+"ajax?"+param;
    	  console.log(url);
        fetch(url)
          .then((response) => response.json())
          .then((data) => addOption(selid, data));
      }

      function addOption(selid, data) {
          let opt = ``;
          initOption(selid);
          console.log(data);
          switch (selid) {
            case "sido":
              opt += `<option value="">시도선택</option>`;
              opt += data.reduce((cur,val)=>{
              	return cur + `
                    <option value="${val}">${val}</option>
                    `
              },``);
              break;
            case "gugun":
              opt += `<option value="">구군선택</option>`;
              opt += data.reduce((cur,val)=>{
              	return cur + `
                    <option value="${val}">${val}</option>
                    `
              },``);
              break;
            case "dong":
              opt += `<option value="">동선택</option>`;
              opt += data.reduce((cur,val)=>{
              	return cur + `
                    <option value="${val.dongCode}">${val.dongName}</option>
                    `
              },``);
              break;
          }
          document.querySelector(`#${selid}`).innerHTML += opt;
        }

      function initOption(selid) {
        let options = document.querySelector(`#${selid}`);
        options.length = 0;
        // let len = options.length;
        // for (let i = len - 1; i >= 0; i--) {
        //   options.remove(i);
        // }
      }

      
      const dongSel = document.querySelector("#dong");
      const dong = dongSel[dongSel.selectedIndex].value;