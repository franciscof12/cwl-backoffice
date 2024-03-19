import SideNav from "@/app/components/sideNav";
import Header from "@/app/components/header";

import {Inter} from "next/font/google";
import {Onest} from "next/font/google";

const interStyle = Inter({subsets: ["latin"]});
const onestFont = Onest({subsets: ["latin"], weight: '400'});

export default function RootLayout({
                                       children,
                                   }: {
    children: React.ReactNode
}) {
    return (
        <>
            <div className={`grid grid-cols-6 grid-rows-10 h-screen w-screen bg-color-ui-crema_white`} style={{...interStyle.style, ...onestFont.style}}>
                <div className="row-span-10 h-full w-full bg-color-ui-crema_black">
                    <SideNav/>
                </div>
                <div className="col-span-5 col-start-2 row-start-1 w-full items-center justify-center p-4 gap-4">
                    <Header/>
                </div>
                <div className="col-span-5 row-span-9 col-start-2 row-start-2  h-full w-full p-4 gap-4">{children}</div>
            </div>
        </>
    )
}
