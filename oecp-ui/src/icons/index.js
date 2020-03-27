import Vue from "vue";
import SvgIcon from "@/components/SvgIcon"; // svg component
import AddTags from "@/components/AddTags"; // svg component
import OecpPage from "@/components/OecpPage"; // svg component
import SearchMessage from "@/components/SearchMessage"; // svg component

// register globally
Vue.component("svg-icon", SvgIcon);
Vue.component("add-tags", AddTags);
Vue.component("oecp-page", OecpPage);
Vue.component("search-message", SearchMessage);

const req = require.context("./svg", false, /\.svg$/);
const requireAll = requireContext => requireContext.keys().map(requireContext);
requireAll(req);
