module.exports = {
    verbose: false,
    testEnvironment: 'jsdom',
    roots: [
      '<rootDir>/test',
    ],
    setupFilesAfterEnv: [
      '<rootDir>/test/index.ts',
    ],
    moduleFileExtensions: [
      'ts',
      'js',
    ],
    moduleDirectories: [
      'node_modules',
    ],
    moduleNameMapper: {
      '^@/test$': '<rootDir>/test/index.js',
      '^@/test/(.*)$': '<rootDir>/test/$1',
      '^@/(.*)$': '<rootDir>/src/$1',
      '\\.(css|sass|scss)$': 'identity-obj-proxy',
    },
    transform: {
      // '\\.(styl)$': 'jest-css-modules',
      // '\\.(sass|scss)$': 'jest-css-modules',
      '.*\\.(j|t)s$': 'ts-jest',
    },
    collectCoverageFrom: [
      'src/**/*.{js,ts,tsx}',
      '!**/*.d.ts',
    ],
    // transformIgnorePatterns: [
    //   'node_modules/(?!vue-router)',
    // ],
    // snapshotSerializers: [
    //   'jest-serializer-html',
    // ],
    testMatch: [
      // Default
      '**/test/**/*.js',
      '**/test/**/*.test.js',
      '**/test/**/*.test.ts',
    ],
  }