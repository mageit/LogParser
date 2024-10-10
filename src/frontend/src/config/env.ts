import dotenv from 'dotenv'

dotenv.config()

interface EnvConfig {
    BASE_API_URL: string
}

const env: EnvConfig = {
    BASE_API_URL: process.env.REACT_APP_BASE_API_URL || 'http://localhost:3000'
}

export default env;