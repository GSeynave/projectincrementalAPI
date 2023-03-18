const { defineConfig } = require('@vue/cli-service')
const { NO } = require('@vue/shared')
const NodePolyfillPlugin = require("node-polyfill-webpack-plugin")

module.exports = defineConfig({
  transpileDependencies: true,
  configureWebpack: {
    plugins: [
      new NodePolyfillPlugin(),
    ]
  },
  chainWebpack: config => {
    config.plugin('polyfill').use(NodePolyfillPlugin)
  }
})
