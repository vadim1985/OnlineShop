<template>
	<div id="selectProps">
		<select v-on:input="$emit('input', $event.target.value)">
			<option :value="indexProps.id +  '/' +  indexProps.name" 
					v-for="indexProps in listProps">{{indexProps.name}}</option>
		</select>
	</div>
</template>
<script>
	import Axios from 'axios'
	export default {
		name: 'selectProps',
		props: ['idtype'],
		data () {
	    	return {
	    		listProps: []
	    	}
	  	},
	  	watch: {
	  		idtype: function (newidtype, oldidtype) {
	  			this.getProps();
	  		}
	  	},
	  	beforeMount(){
			this.getProps();
	  	},
	  	methods:{
	  		getProps(){
	  		Axios.get("http://localhost:8081/parameter/" + this.idtype)
			.then(response =>{
					this.listProps = response.data;
					this.listProps.unshift("");
					console.log(response.data);
				});
	  		}
	  	}
	}
</script>