const path = require('path')
const OptimizeCSSAssetsPlugin = require('optimize-css-assets-webpack-plugin')
const TerserPlugin = require('terser-webpack-plugin')
const CompressionPlugin = require('compression-webpack-plugin')
const WebpackBundleAnalyzer = require('webpack-bundle-analyzer').BundleAnalyzerPlugin

const isAnalyze = false // bundleAnalyzer

function resolve (dir) {
  return path.join(__dirname, dir)
}

module.exports = {

  // The base URL your application bundle will be deployed at
  publicPath: '/',

  // The directory where the production build files will be generated in when running vue-cli-service build.
  outputDir: 'dist',

  // A directory (relative to outputDir) to nest generated static assets (js, css, img, fonts) under.
  assetsDir: 'public',

  // Specify the output path for the generated home.html (relative to outputDir). Can also be an absolute path.
  indexPath: 'index.html',

  // If you cannot make use of the app HTML generated by Vue CLI, you can disable filename hashing by setting this option to false.
  filenameHashing: true,

  // Build the app in multi-page mode. Each "page" should have a corresponding JavaScript entry file.
  pages: undefined,

  // Whether to perform lint-on-save during development using eslint-loader. boolean | 'error'
  lintOnSave: true,

  // Whether to use the build of Vue core that includes the runtime compiler.
  runtimeCompiler: false,

  // By default babel-loader ignores all files inside node_modules. If you want to explicitly transpile a dependency with Babel, you can list it in this option. Array<string | RegExp>
  transpileDependencies: [],

  // Setting this to false can speed up production builds if you don't need source maps for production.
  productionSourceMap: false,

  // Configure the crossorigin attribute on <link rel="stylesheet"> and <script> tags in generated HTML.
  // crossOrigin: undefined,

  // Set to true to enable Subresource Integrity (SRI) on <link rel="stylesheet"> and <script> tags in generated HTML.
  integrity: false,

  // If the value is an Object, it will be merged into the final projVueConfig using webpack-merge.
  configureWebpack: {
    plugins: [
      new CompressionPlugin({
        algorithm: 'gzip',
        test: new RegExp('\\.(' + ['js', 'css'].join('|') + ')$'),
        threshold: 10240,
        minRatio: 0.8
      })
    ],
    optimization: {
      namedChunks: true,
      runtimeChunk: 'single',
      splitChunks: {
        chunks: 'all',
        cacheGroups: {
          libs: {
            name: 'chunk-libs',
            test: /[\\/]node_modules[\\/]/,
            priority: 10,
            chunks: 'initial'
          },
          elementUI: {
            name: 'chunk-theme',
            priority: 20,
            test: /[\\/]node_modules[\\/]element-ui[\\/]/
          },
          commons: {
            name: 'chunk-commons',
            test: resolve('src/components'),
            minChunks: 3,
            priority: 5,
            reuseExistingChunk: true
          }
        }
      },
      minimizer: [
        new TerserPlugin({
          terserOptions: {
            compress: {
              warnings: false,
              drop_debugger: true,
              drop_console: true,
              pure_funcs: ['console.log', 'debugger']
            }
          },
          sourceMap: false,
          cache: true,
          parallel: true
        }),
        new OptimizeCSSAssetsPlugin()
      ]
    },
    performance: {
      hints: 'warning',
      maxAssetSize: 30000000,
      maxEntrypointSize: 50000000,
      assetFilter: function (assetFilename) {
        return assetFilename.endsWith('.css') || assetFilename.endsWith('.js')
      }
    }
  },

  // A function that will receive an instance of ChainableConfig powered by webpack-chain.
  chainWebpack: config => {
    config.resolve.alias
      .set('@', resolve('src'))

    config.module
      .rule('svg')
      .exclude.add(resolve('src/icons'))
      .end()

    config.module
      .rule('icons')
      .test(/\.svg$/)
      .include.add(resolve('src/icons'))
      .end()
      .use('svg-sprite-loader')
      .loader('svg-sprite-loader')
      .options({
        symbolId: 'icon-[name]'
      })

    if (isAnalyze) { // 设置bundle-analyzer
      config
        .plugin('bundle-analyzer')
        .use(WebpackBundleAnalyzer)
    }
  },

  css: {

    extract: true,

    // By default, only files that ends in *.module.[ext] are treated as CSS modules.
    modules: false,

    // Whether to extract CSS in your views into a standalone CSS files (instead of inlined in JavaScript and injected dynamically).
    // extract: process.env.NODE_ENV === 'production',

    // Whether to enable source maps for CSS. Setting this to true may affect build performance.
    sourceMap: false,

    // Pass options to CSS-related loaders
    loaderOptions: {
      sass: {
        data: `
          @import "@/assets/style/global_var.scss";
        `
      }
    }
  },

  // Various Dev Server settings
  devServer: {
    host: 'localhost', // can be overwritten by process.env.HOST
    port: 80, // can be overwritten by process.env.PORT, if port is in use, a free one will be determined
    hotOnly: true,
    headers: {} // Adds headers to all responses
    // allowedHosts: [], // This option allows you to whitelist services that are allowed to access the dev server
    // proxy: {} // Proxying some URLs can be useful when you have a separate API backend development server and you want to send API requests on the same domain
  },

  // Whether to use thread-loader for Babel or TypeScript transpilation. This is enabled for production builds when the system has more than 1 CPU cores.
  parallel: require('os').cpus().length > 1,

  // Pass options to the PWA Plugin.
  pwa: {},

  // This is an object that doesn't go through any schema validation, so it can be used to pass arbitrary options to 3rd party plugins.
  pluginOptions: {}

}
