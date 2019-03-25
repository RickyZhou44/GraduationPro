// https://eslint.org/docs/user-guide/configuring

module.exports = {
  root: true,
  env: {
    node: true
  },
  extends: [
    'plugin:vue/essential',
    '@vue/standard'
  ],
  rules: {
    'vue/script-indent': ['error', 2, { 'baseIndent': 1 }],
    'no-control-regex': 0,
    'no-tabs': 0,
    'no-useless-escape': 0
  },
  overrides: [
    {
      files: ['*.vue'],
      rules: {
        indent: "off"
      }
    }
  ],
  parserOptions: {
    parser: 'babel-eslint'
  },
  plugins: [
    'flowtype'
  ],
  settings: {}
}
