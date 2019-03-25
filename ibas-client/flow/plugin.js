declare type validateRule = {
  required?: boolean,
  message?: string,
  trigger?: string,
  validate?: Function,
  min?: number,
  max?: number,
  type?: 'string' | 'number' | 'boolean' | 'method' | 'regexp' | 'integer' | 'float' | 'array' | 'object' | 'enum' | 'date' | 'url' | 'hex' | 'email',
  pattern?: RegExp,
  len?: number,
  enum: Array<any>,
  Whitespace: boolean
}
