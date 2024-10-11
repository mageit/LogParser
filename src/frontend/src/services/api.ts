import axios from "axios";

export const analyseLogfile = async (file: File) => {
    const formData = new FormData();
    formData.append('logs', file);

    try {
        const response = await axios.post('http://localhost:8080/parse', formData, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        });
        console.log(response);
    } catch(error) {
        console.error(error);
    }

}