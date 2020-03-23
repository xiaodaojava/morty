<template>
  <div id="dream">
    <el-select v-model="message" placeholder="请选择" @change="changeAction">
      <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value"></el-option>
    </el-select>
    <el-select v-model="message2" placeholder="请选择">
      <el-option v-for="item in option4" :key="item.value" :label="item.label" :value="item.value"></el-option>
    </el-select>
  </div>
</template>

<script>
export default {
  data() {
    return {
      message: "",
      message2: "",
      options: [
        {
          value: 1,
          label: "test"
        },
        {
          value: 2,
          label: "test1"
        },
        {
          value: 3,
          label: "test2"
        },
        {
          value: 4,
          label: "test3"
        },
        {
          value: 5,
          label: "test4"
        }
      ],
      option2: [
        {
          value: 1,
          label: "test--小test",
          id: 1
        },
        {
          value: 2,
          label: "test--继续加油",
          id: 1
        }
      ],
      option3: [
        {
          value: 11,
          label: "test--小test"
        },
        {
          value: 12,
          label: "test--继续加油"
        },
        {
          value: 13,
          label: "test1--锁"
        },
        {
          value: 14,
          label: "test1--BBB"
        },
        {
          value: 15,
          label: "test1--LLL"
        }
      ],
      option5: [
        {
          value: 3,
          label: "test1--锁",
          id: 2
        },
        {
          value: 4,
          label: "test1--BBB",
          id: 2
        },
        {
          value: 5,
          label: "test1--LLL",
          id: 2
        }
      ],
      option4: []
    };
  },
  methods: {
    changeAction() {
      console.log(this.message);
      if (this.message == 1) {
        this.option4 = this.option2;
      } else if (this.message == 2) {
        this.option4 = this.option5;
      }
    }
  },
  mounted() {
    this.option4 = this.option3;
  }
};
</script>