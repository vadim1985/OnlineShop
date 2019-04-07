import Vue from 'vue'
import Vuex from 'vuex'
import Axios from 'axios'

Vue.use(Vuex)

	var state = {
		listTypeOfParameter: null
	};

	var getters = {
		getListTypeOfParameter: state => {
			return state.listTypeOfParameter;
		}
	};

	var mutations = {
		setListTypeOfParameter: (state, payload) => {
			state.listTypeOfParameter = payload;
		},
		pushTypeOfParameter: (state, payload) => {
			state.listTypeOfParameter.push(payload);
		},
	};

	var actions = {
		loadListTypeOfParameter: context => {
			Axios.get("http://localhost:8081/typeOfParameter")
			.then(response => {
      			let data = response.data;
     		 	context.commit('setListTypeOfParameter', data)
    		});
    	},
    	loadListParameterInType: (context, payload) => {
    		Axios({
				method: 'post',
				url: 'http://localhost:8081/parameter',
				data: payload
			});
    	},
    	loadTypeOfParameter: (context, payload) => {
    		Axios({
				method: 'post',
				url: 'http://localhost:8081/typeOfParameter',
				data: payload
			}).then(response => {
				context.commit('pushTypeOfParameter', response.data);
			});

    	}
	};

	export default {
		state,
		getters,
		mutations,
		actions
	}