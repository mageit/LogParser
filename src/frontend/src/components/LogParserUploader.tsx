import React from "react";
import {analyseLogfile} from "@/services/api";

const LogParserUploader = () => {
    const [file, setFile] = React.useState<File | null>(null);
    const [isBusy, setIsBusy] = React.useState(false);

    const handleFileChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        if(event.target.files) {
            setFile(event.target.files[0]);
        }
    };

    const handleUpload = async () => {
        setIsBusy(true);
        await analyseLogfile(file as File);
        setIsBusy(false);


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

            {file &&  !isBusy && (
                <button
                    onClick={handleUpload}
                    className="Start Analyse"
                    disabled={isBusy}
                >Upload a file</button>
            )}

            {isBusy && (
                <p>Processing...</p>
            )}
        </>
    );
}

export default LogParserUploader;
