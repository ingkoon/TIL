const axios = require('axios');

async function request(sub_path){
	
	const url = 'http://13.124.193.201:8080/' + sub_path
	
	try{	
		const response = await axios.get(url);											
		return response.data
	}
	catch(e){

		console.log(e)
	}
}


const array = ['a', 'b', 'c', 'd', 'e']

async function test(){

	for(const item of array) {
		const resolve = await request(item)
	
		console.log(resolve)				
	}
}

test()


