import Vue from 'vue'
import Vuex from 'vuex'
import productTypeAndCategory from './moduleProductTypeAndCategory.js'
import typeOfParameterAndParameters from './moduleTypeOfParameterAndParameters.js'
import product from './moduleProduct.js'

Vue.use(Vuex)

export default new Vuex.Store({
	state:{},
	getters: {},
	mutations:{},
	actions:{},
	modules: {
		productTypeAndCategory,
		typeOfParameterAndParameters,
		product
	}
});