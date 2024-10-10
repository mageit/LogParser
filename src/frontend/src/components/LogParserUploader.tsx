import React from "react";

const LogParserUploader = () => {
    const [file, setFile] = React.useState<File | null>(null);

    const handleFileChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        if(event.target.files) {
            setFile(event.target.files[0]);
        }
    };

    const handleUpload = async () => {

    }

    return (
        <>
            <div className="uploader">
                <input type="file" accept=".log" onChange={handleFileChange}/>
            </div>
            {file && (
                <section>
                    <br />
                    Selected log file details:
                    <ul>
                        <li>Name: {file.name}</li>
                        <li>Size: {file.size} bytes</li>
                    </ul>
                </section>
            )}

            {file && (
                <button
                    onClick={handleUpload}
                    className="Start Analyse"
                >Upload a file</button>
            )}
        </>
    );
}

export default LogParserUploader;
