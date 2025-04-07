// Populate the sidebar
//
// This is a script, and not included directly in the page, to control the total size of the book.
// The TOC contains an entry for each page, so if each page includes a copy of the TOC,
// the total size of the page becomes O(n**2).
class MDBookSidebarScrollbox extends HTMLElement {
    constructor() {
        super();
    }
    connectedCallback() {
        this.innerHTML = '<ol class="chapter"><li class="chapter-item expanded affix "><a href="overview.html">Projects Overview</a></li><li class="chapter-item expanded affix "><a href="background/character_sheet.html">Project Background: Character Sheet</a></li><li class="chapter-item expanded affix "><a href="background/dice_game.html">Project Background: Dice Game</a></li><li class="chapter-item expanded "><a href="project1.html"><strong aria-hidden="true">1.</strong> Project 1: Character Sheet Part 1</a></li><li class="chapter-item expanded "><a href="project2.html"><strong aria-hidden="true">2.</strong> Project 2: Character Sheet Part 2</a></li><li class="chapter-item expanded "><a href="project3.html"><strong aria-hidden="true">3.</strong> Project 3: Dice Game Part 1</a></li><li class="chapter-item expanded "><a href="project4.html"><strong aria-hidden="true">4.</strong> Project 4: Dice Game Part 2</a></li><li class="chapter-item expanded "><div><strong aria-hidden="true">5.</strong> Project 5: Complete Character Sheet</div></li><li class="chapter-item expanded "><div><strong aria-hidden="true">6.</strong> Project 6: Complete Dice Game</div></li><li class="chapter-item expanded "><div><strong aria-hidden="true">7.</strong> Self-Directed Projects</div></li><li class="chapter-item expanded "><div><strong aria-hidden="true">8.</strong> Testing</div></li><li><ol class="section"><li class="chapter-item expanded "><div><strong aria-hidden="true">8.1.</strong> The Test Program</div></li><li class="chapter-item expanded "><div><strong aria-hidden="true">8.2.</strong> Download</div></li><li class="chapter-item expanded "><div><strong aria-hidden="true">8.3.</strong> Testing Guide</div></li></ol></li></ol>';
        // Set the current, active page, and reveal it if it's hidden
        let current_page = document.location.href.toString().split("#")[0];
        if (current_page.endsWith("/")) {
            current_page += "index.html";
        }
        var links = Array.prototype.slice.call(this.querySelectorAll("a"));
        var l = links.length;
        for (var i = 0; i < l; ++i) {
            var link = links[i];
            var href = link.getAttribute("href");
            if (href && !href.startsWith("#") && !/^(?:[a-z+]+:)?\/\//.test(href)) {
                link.href = path_to_root + href;
            }
            // The "index" page is supposed to alias the first chapter in the book.
            if (link.href === current_page || (i === 0 && path_to_root === "" && current_page.endsWith("/index.html"))) {
                link.classList.add("active");
                var parent = link.parentElement;
                if (parent && parent.classList.contains("chapter-item")) {
                    parent.classList.add("expanded");
                }
                while (parent) {
                    if (parent.tagName === "LI" && parent.previousElementSibling) {
                        if (parent.previousElementSibling.classList.contains("chapter-item")) {
                            parent.previousElementSibling.classList.add("expanded");
                        }
                    }
                    parent = parent.parentElement;
                }
            }
        }
        // Track and set sidebar scroll position
        this.addEventListener('click', function(e) {
            if (e.target.tagName === 'A') {
                sessionStorage.setItem('sidebar-scroll', this.scrollTop);
            }
        }, { passive: true });
        var sidebarScrollTop = sessionStorage.getItem('sidebar-scroll');
        sessionStorage.removeItem('sidebar-scroll');
        if (sidebarScrollTop) {
            // preserve sidebar scroll position when navigating via links within sidebar
            this.scrollTop = sidebarScrollTop;
        } else {
            // scroll sidebar to current active section when navigating via "next/previous chapter" buttons
            var activeSection = document.querySelector('#sidebar .active');
            if (activeSection) {
                activeSection.scrollIntoView({ block: 'center' });
            }
        }
        // Toggle buttons
        var sidebarAnchorToggles = document.querySelectorAll('#sidebar a.toggle');
        function toggleSection(ev) {
            ev.currentTarget.parentElement.classList.toggle('expanded');
        }
        Array.from(sidebarAnchorToggles).forEach(function (el) {
            el.addEventListener('click', toggleSection);
        });
    }
}
window.customElements.define("mdbook-sidebar-scrollbox", MDBookSidebarScrollbox);
