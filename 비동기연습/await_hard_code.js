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

async function test(){
	const resolve_0 = await request('a').then();
	console.log(resolve_0)
	const resolve_1 = await request('b').then();
	console.log(resolve_1)
	const resolve_2 = await request('c').then();
	console.log(resolve_2)
	const resolve_3 = await request('d').then();
	console.log(resolve_3)
	const resolve_4 = await request('e').then();
	console.log(resolve_4)
}

test()