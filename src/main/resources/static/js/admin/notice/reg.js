let init = () => {
	const section = document.querySelector('#dnd-section');
	const uploadBox = section.querySelector('.upload-box');
	const progressStatusDiv = document.querySelector('.progress-status');
	const fileInput = document.querySelectorAll('.form input[type="file"]')[0];
	
	fileInput.addEventListener('input', (e) => {
		let file = fileInput.files[0];
		if (file.type.indexOf("image/") < 0)
			alert('이미지 형식만 사용할 수 있습니다.');
		
		let reader = new FileReader();
		reader.addEventListener('load', (e) => {
			let img = document.createElement('img');
			img.src = e.target.result;
			fileInput.insertAdjacentElement('afterend', img);	
		});
		reader.readAsDataURL(file);
	});
	
	uploadBox.addEventListener('dragenter', (e) => {

	});
	
	uploadBox.addEventListener('dragleave', (e) => {
		uploadBox.classList.remove('valid');
		uploadBox.classList.remove('invalid');
	});
	
	uploadBox.addEventListener('dragover', (e) => {
		e.preventDefault();
		let dt = e.dataTransfer;
			
		let valid = e.dataTransfer.types.indexOf('Files') !== -1;
		if (valid) {
			uploadBox.classList.add('valid');
		} else {
			uploadBox.classList.add('invalid');
		}
	});
	
	uploadBox.addEventListener('drop', (e) => {
		e.preventDefault();
		uploadBox.classList.remove('valid');
		uploadBox.classList.remove('invalid');
		
		let dt = e.dataTransfer;
		if (dt.files.length > 1) {
			alert('파일은 하나씩만 전송이 가능합니다.');
			return;
		}
		
		if (dt.files[0].size > 100*1024*1024) {
			alert('파일 용량을 10MByte를 초과할 수 없습니다.');
			return;
		}
		
		let formData = new FormData();
		formData.append('path', '/upload/test');
		formData.append('file', dt.files[0]);
		
		let request = new XMLHttpRequest();
		request.addEventListener('load', () => {
			console.log('response ok');
			//let json = JSON.parse(request.responseText);
			//console.log(json);
			//let li = `<li><a download href='${request.responseText}'>${request.responseText}</a></li>`;
			let li = `<li><img src="${request.response}" style="width: 100px; heigth: 100px;" /></li>`;
			console.log(li);
			let ul = progressStatusDiv.lastElementChild;
			console.log(ul);
			ul.insertAdjacentHTML('beforeend', li);
		});
		
		request.upload.addEventListener('progress', (e) => {
			console.log(`total:${e.total} loaded:${e.loaded}`);
			let status = Math.round(e.loaded*100/e.total)+'%';
			let bar = progressStatusDiv.firstElementChild.firstElementChild;
			bar.style.width = status;
			bar.textContent = status;
			fileStatus.value = parseInt(status);
			
		});
		
		request.open('POST', '/admin/uploader', true);
		request.send(formData);
	});
}

window.addEventListener('load', init());