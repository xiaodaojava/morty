import Vue from "vue";
import SvgIcon from "@/components/SvgIcon"; 
import AddTags from "@/components/AddTags";
import AddCaseInfo from "@/components/AddCaseInfo";
import OecpPage from "@/components/OecpPage"; 
import SearchMessage from "@/components/SearchMessage"; 

// register globally
Vue.component("svg-icon", SvgIcon);
Vue.component("add-tags", AddTags);
Vue.component("add-case-info", AddCaseInfo);
Vue.component("oecp-page", OecpPage);
Vue.component("search-message", SearchMessage);

const req = require.context("./svg", false, /\.svg$/);
const requireAll = requireContext => requireContext.keys().map(requireContext);
requireAll(req);
